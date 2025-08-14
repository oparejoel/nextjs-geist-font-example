## UI Components

All components are exported from files in `src/components/ui/*` and are designed to be composable, accessible, and Tailwind-friendly. Import using the `@/*` alias.

General import pattern:
```tsx
import { ComponentName } from '@/components/ui/component-file'
```

Each section lists the exports provided by that file and a basic usage example.

### Accordion (`accordion.tsx`)
- **Exports**: `Accordion`, `AccordionItem`, `AccordionTrigger`, `AccordionContent`
- **Example**:
```tsx
import { Accordion, AccordionItem, AccordionTrigger, AccordionContent } from '@/components/ui/accordion'

<Accordion type="single" collapsible>
  <AccordionItem value="item-1">
    <AccordionTrigger>What is this?</AccordionTrigger>
    <AccordionContent>A composable accordion built on Radix.</AccordionContent>
  </AccordionItem>
</Accordion>
```

### Alert (`alert.tsx`)
- **Exports**: `Alert`, `AlertTitle`, `AlertDescription`
- **Example**:
```tsx
import { Alert, AlertTitle, AlertDescription } from '@/components/ui/alert'

<Alert>
  <AlertTitle>Heads up</AlertTitle>
  <AlertDescription>Something noteworthy happened.</AlertDescription>
</Alert>
```

### Alert Dialog (`alert-dialog.tsx`)
- **Exports**: `AlertDialog`, `AlertDialogPortal`, `AlertDialogOverlay`, `AlertDialogTrigger`, `AlertDialogContent`, `AlertDialogHeader`, `AlertDialogFooter`, `AlertDialogTitle`, `AlertDialogDescription`, `AlertDialogAction`, `AlertDialogCancel`
- **Example**:
```tsx
import { AlertDialog, AlertDialogTrigger, AlertDialogContent, AlertDialogAction, AlertDialogCancel, AlertDialogHeader, AlertDialogTitle, AlertDialogDescription, AlertDialogFooter } from '@/components/ui/alert-dialog'

<AlertDialog>
  <AlertDialogTrigger asChild>
    <button>Delete</button>
  </AlertDialogTrigger>
  <AlertDialogContent>
    <AlertDialogHeader>
      <AlertDialogTitle>Are you sure?</AlertDialogTitle>
      <AlertDialogDescription>This action cannot be undone.</AlertDialogDescription>
    </AlertDialogHeader>
    <AlertDialogFooter>
      <AlertDialogCancel>Cancel</AlertDialogCancel>
      <AlertDialogAction>Confirm</AlertDialogAction>
    </AlertDialogFooter>
  </AlertDialogContent>
</AlertDialog>
```

### Aspect Ratio (`aspect-ratio.tsx`)
- **Exports**: `AspectRatio`
- **Example**:
```tsx
import { AspectRatio } from '@/components/ui/aspect-ratio'

<AspectRatio ratio={16/9}>
  <img src="/hero.jpg" alt="" className="h-full w-full object-cover" />
</AspectRatio>
```

### Avatar (`avatar.tsx`)
- **Exports**: `Avatar`, `AvatarImage`, `AvatarFallback`
- **Example**:
```tsx
import { Avatar, AvatarImage, AvatarFallback } from '@/components/ui/avatar'

<Avatar>
  <AvatarImage src="/user.png" />
  <AvatarFallback>AD</AvatarFallback>
</Avatar>
```

### Badge (`badge.tsx`)
- **Exports**: `Badge`, `badgeVariants`
- **Example**:
```tsx
import { Badge } from '@/components/ui/badge'

<Badge>New</Badge>
```

### Breadcrumb (`breadcrumb.tsx`)
- **Exports**: `Breadcrumb`, `BreadcrumbList`, `BreadcrumbItem`, `BreadcrumbLink`, `BreadcrumbPage`, `BreadcrumbSeparator`, `BreadcrumbEllipsis`
- **Example**:
```tsx
import { Breadcrumb, BreadcrumbList, BreadcrumbItem, BreadcrumbLink, BreadcrumbSeparator } from '@/components/ui/breadcrumb'

<Breadcrumb>
  <BreadcrumbList>
    <BreadcrumbItem>
      <BreadcrumbLink href="/">Home</BreadcrumbLink>
    </BreadcrumbItem>
    <BreadcrumbSeparator />
    <BreadcrumbItem>Settings</BreadcrumbItem>
  </BreadcrumbList>
</Breadcrumb>
```

### Button (`button.tsx`)
- **Exports**: `Button`, `buttonVariants`
- **Props**: `variant` (`default | destructive | outline | secondary | ghost | link`), `size` (`default | sm | lg | icon`), `asChild?: boolean`
- **Example**:
```tsx
import { Button } from '@/components/ui/button'

<Button>Save</Button>
<Button variant="destructive">Delete</Button>
<Button size="icon" aria-label="Like">❤️</Button>
```

### Calendar (`calendar.tsx`)
- **Exports**: `Calendar`
- **Example**:
```tsx
import { Calendar } from '@/components/ui/calendar'

<Calendar mode="single" selected={new Date()} onSelect={console.log} />
```

### Card (`card.tsx`)
- **Exports**: `Card`, `CardHeader`, `CardFooter`, `CardTitle`, `CardAction`, `CardDescription`, `CardContent`
- **Example**:
```tsx
import { Card, CardHeader, CardTitle, CardDescription, CardContent, CardFooter } from '@/components/ui/card'

<Card>
  <CardHeader>
    <CardTitle>Project</CardTitle>
    <CardDescription>Overview</CardDescription>
  </CardHeader>
  <CardContent>...</CardContent>
  <CardFooter>...</CardFooter>
</Card>
```

### Carousel (`carousel.tsx`)
- **Exports**: `Carousel`, `CarouselContent`, `CarouselItem`, `CarouselPrevious`, `CarouselNext`, and `type CarouselApi`
- **Example**:
```tsx
import { Carousel, CarouselContent, CarouselItem, CarouselPrevious, CarouselNext } from '@/components/ui/carousel'

<Carousel>
  <CarouselContent>
    {[1,2,3].map(i => (
      <CarouselItem key={i} className="basis-1/3">Item {i}</CarouselItem>
    ))}
  </CarouselContent>
  <CarouselPrevious />
  <CarouselNext />
</Carousel>
```

### Chart (`chart.tsx`)
- **Exports**: `ChartContainer`, `ChartTooltip`, `ChartTooltipContent`, `ChartLegend`, `ChartLegendContent`, `ChartStyle`, and `type ChartConfig`
- **Example**:
```tsx
import { ChartContainer, ChartLegend, ChartLegendContent, ChartStyle } from '@/components/ui/chart'

<ChartStyle />
<ChartContainer config={{}}
  className="h-64 w-full"
>
  {/* Render your chart library inside */}
  <ChartLegend>
    <ChartLegendContent />
  </ChartLegend>
</ChartContainer>
```

### Checkbox (`checkbox.tsx`)
- **Exports**: `Checkbox`
- **Example**:
```tsx
import { Checkbox } from '@/components/ui/checkbox'

<label className="flex items-center gap-2">
  <Checkbox id="terms" /> I agree
</label>
```

### Collapsible (`collapsible.tsx`)
- **Exports**: `Collapsible`, `CollapsibleTrigger`, `CollapsibleContent`
- **Example**:
```tsx
import { Collapsible, CollapsibleTrigger, CollapsibleContent } from '@/components/ui/collapsible'

<Collapsible>
  <CollapsibleTrigger>Show more</CollapsibleTrigger>
  <CollapsibleContent>Hidden content</CollapsibleContent>
</Collapsible>
```

### Command (`command.tsx`)
- **Exports**: `Command`, `CommandDialog`, `CommandInput`, `CommandList`, `CommandEmpty`, `CommandGroup`, `CommandItem`, `CommandShortcut`, `CommandSeparator`
- **Example**:
```tsx
import { Command, CommandInput, CommandList, CommandEmpty, CommandGroup, CommandItem } from '@/components/ui/command'

<Command>
  <CommandInput placeholder="Type a command or search..." />
  <CommandList>
    <CommandEmpty>No results.</CommandEmpty>
    <CommandGroup heading="Suggestions">
      <CommandItem>Open</CommandItem>
      <CommandItem>Save</CommandItem>
    </CommandGroup>
  </CommandList>
</Command>
```

### Context Menu (`context-menu.tsx`)
- **Exports**: `ContextMenu`, `ContextMenuTrigger`, `ContextMenuContent`, `ContextMenuItem`, `ContextMenuCheckboxItem`, `ContextMenuRadioItem`, `ContextMenuLabel`, `ContextMenuSeparator`, `ContextMenuShortcut`, `ContextMenuGroup`, `ContextMenuPortal`, `ContextMenuSub`, `ContextMenuSubContent`, `ContextMenuSubTrigger`, `ContextMenuRadioGroup`
- **Example**:
```tsx
import { ContextMenu, ContextMenuTrigger, ContextMenuContent, ContextMenuItem, ContextMenuSeparator } from '@/components/ui/context-menu'

<ContextMenu>
  <ContextMenuTrigger asChild>
    <div className="p-4 border">Right-click me</div>
  </ContextMenuTrigger>
  <ContextMenuContent>
    <ContextMenuItem>Copy</ContextMenuItem>
    <ContextMenuSeparator />
    <ContextMenuItem>Delete</ContextMenuItem>
  </ContextMenuContent>
</ContextMenu>
```

### Dialog (`dialog.tsx`)
- **Exports**: `Dialog`, `DialogClose`, `DialogContent`, `DialogDescription`, `DialogFooter`, `DialogHeader`, `DialogOverlay`, `DialogPortal`, `DialogTitle`, `DialogTrigger`
- **Example**:
```tsx
import { Dialog, DialogTrigger, DialogContent, DialogHeader, DialogTitle, DialogDescription } from '@/components/ui/dialog'

<Dialog>
  <DialogTrigger asChild>
    <button>Open dialog</button>
  </DialogTrigger>
  <DialogContent>
    <DialogHeader>
      <DialogTitle>Title</DialogTitle>
      <DialogDescription>Details...</DialogDescription>
    </DialogHeader>
  </DialogContent>
</Dialog>
```

### Drawer (`drawer.tsx`)
- **Exports**: `Drawer`, `DrawerPortal`, `DrawerOverlay`, `DrawerTrigger`, `DrawerClose`, `DrawerContent`, `DrawerHeader`, `DrawerFooter`, `DrawerTitle`, `DrawerDescription`
- **Example**:
```tsx
import { Drawer, DrawerTrigger, DrawerContent, DrawerHeader, DrawerTitle } from '@/components/ui/drawer'

<Drawer>
  <DrawerTrigger asChild>
    <button>Open drawer</button>
  </DrawerTrigger>
  <DrawerContent>
    <DrawerHeader>
      <DrawerTitle>Drawer</DrawerTitle>
    </DrawerHeader>
  </DrawerContent>
</Drawer>
```

### Dropdown Menu (`dropdown-menu.tsx`)
- **Exports**: `DropdownMenu`, `DropdownMenuPortal`, `DropdownMenuTrigger`, `DropdownMenuContent`, `DropdownMenuGroup`, `DropdownMenuLabel`, `DropdownMenuItem`, `DropdownMenuCheckboxItem`, `DropdownMenuRadioGroup`, `DropdownMenuRadioItem`, `DropdownMenuSeparator`, `DropdownMenuShortcut`, `DropdownMenuSub`, `DropdownMenuSubTrigger`, `DropdownMenuSubContent`
- **Example**:
```tsx
import { DropdownMenu, DropdownMenuTrigger, DropdownMenuContent, DropdownMenuItem, DropdownMenuSeparator } from '@/components/ui/dropdown-menu'

<DropdownMenu>
  <DropdownMenuTrigger asChild>
    <button>Open</button>
  </DropdownMenuTrigger>
  <DropdownMenuContent>
    <DropdownMenuItem>Profile</DropdownMenuItem>
    <DropdownMenuSeparator />
    <DropdownMenuItem>Logout</DropdownMenuItem>
  </DropdownMenuContent>
</DropdownMenu>
```

### Form (`form.tsx`)
- **Exports**: `useFormField`, `Form`, `FormItem`, `FormLabel`, `FormControl`, `FormDescription`, `FormMessage`, `FormField`
- **Example** (with react-hook-form):
```tsx
import { useForm } from 'react-hook-form'
import { Form, FormField, FormItem, FormLabel, FormControl, FormMessage } from '@/components/ui/form'
import { Input } from '@/components/ui/input'

const form = useForm<{ email: string }>({ defaultValues: { email: '' } })

<Form {...form}>
  <form onSubmit={form.handleSubmit(console.log)}>
    <FormField name="email" control={form.control} render={({ field }) => (
      <FormItem>
        <FormLabel>Email</FormLabel>
        <FormControl>
          <Input type="email" placeholder="you@example.com" {...field} />
        </FormControl>
        <FormMessage />
      </FormItem>
    )} />
  </form>
</Form>
```

### Hover Card (`hover-card.tsx`)
- **Exports**: `HoverCard`, `HoverCardTrigger`, `HoverCardContent`
- **Example**:
```tsx
import { HoverCard, HoverCardTrigger, HoverCardContent } from '@/components/ui/hover-card'

<HoverCard>
  <HoverCardTrigger>Hover me</HoverCardTrigger>
  <HoverCardContent>Details...</HoverCardContent>
</HoverCard>
```

### Input OTP (`input-otp.tsx`)
- **Exports**: `InputOTP`, `InputOTPGroup`, `InputOTPSlot`, `InputOTPSeparator`
- **Example**:
```tsx
import { InputOTP, InputOTPGroup, InputOTPSlot } from '@/components/ui/input-otp'

<InputOTP maxLength={6}>
  <InputOTPGroup>
    {Array.from({ length: 6 }).map((_, i) => (
      <InputOTPSlot key={i} index={i} />
    ))}
  </InputOTPGroup>
</InputOTP>
```

### Input (`input.tsx`)
- **Exports**: `Input`
- **Example**:
```tsx
import { Input } from '@/components/ui/input'

<Input placeholder="Search..." />
```

### Label (`label.tsx`)
- **Exports**: `Label`
- **Example**:
```tsx
import { Label } from '@/components/ui/label'

<Label htmlFor="name">Name</Label>
```

### Menubar (`menubar.tsx`)
- **Exports**: `Menubar`, `MenubarPortal`, `MenubarMenu`, `MenubarTrigger`, `MenubarContent`, `MenubarGroup`, `MenubarSeparator`, `MenubarLabel`, `MenubarItem`, `MenubarShortcut`, `MenubarCheckboxItem`, `MenubarRadioGroup`, `MenubarRadioItem`, `MenubarSub`, `MenubarSubTrigger`, `MenubarSubContent`
- **Example**:
```tsx
import { Menubar, MenubarMenu, MenubarTrigger, MenubarContent, MenubarItem } from '@/components/ui/menubar'

<Menubar>
  <MenubarMenu>
    <MenubarTrigger>File</MenubarTrigger>
    <MenubarContent>
      <MenubarItem>New</MenubarItem>
      <MenubarItem>Open</MenubarItem>
    </MenubarContent>
  </MenubarMenu>
</Menubar>
```

### Navigation Menu (`navigation-menu.tsx`)
- **Exports**: `NavigationMenu`, `NavigationMenuList`, `NavigationMenuItem`, `NavigationMenuContent`, `NavigationMenuTrigger`, `NavigationMenuLink`, `NavigationMenuIndicator`, `NavigationMenuViewport`, `navigationMenuTriggerStyle`
- **Example**:
```tsx
import { NavigationMenu, NavigationMenuList, NavigationMenuItem, NavigationMenuTrigger, NavigationMenuContent } from '@/components/ui/navigation-menu'

<NavigationMenu>
  <NavigationMenuList>
    <NavigationMenuItem>
      <NavigationMenuTrigger>Products</NavigationMenuTrigger>
      <NavigationMenuContent>...</NavigationMenuContent>
    </NavigationMenuItem>
  </NavigationMenuList>
</NavigationMenu>
```

### Pagination (`pagination.tsx`)
- **Exports**: `Pagination`, `PaginationContent`, `PaginationLink`, `PaginationItem`, `PaginationPrevious`, `PaginationNext`, `PaginationEllipsis`
- **Example**:
```tsx
import { Pagination, PaginationContent, PaginationItem, PaginationPrevious, PaginationNext } from '@/components/ui/pagination'

<Pagination>
  <PaginationContent>
    <PaginationPrevious href="#" />
    <PaginationItem>1</PaginationItem>
    <PaginationNext href="#" />
  </PaginationContent>
</Pagination>
```

### Popover (`popover.tsx`)
- **Exports**: `Popover`, `PopoverTrigger`, `PopoverContent`, `PopoverAnchor`
- **Example**:
```tsx
import { Popover, PopoverTrigger, PopoverContent } from '@/components/ui/popover'

<Popover>
  <PopoverTrigger asChild>
    <button>Open</button>
  </PopoverTrigger>
  <PopoverContent className="w-64">Content</PopoverContent>
</Popover>
```

### Progress (`progress.tsx`)
- **Exports**: `Progress`
- **Example**:
```tsx
import { Progress } from '@/components/ui/progress'

<Progress value={33} />
```

### Radio Group (`radio-group.tsx`)
- **Exports**: `RadioGroup`, `RadioGroupItem`
- **Example**:
```tsx
import { RadioGroup, RadioGroupItem } from '@/components/ui/radio-group'

<RadioGroup value="a" onValueChange={console.log}>
  <div className="flex items-center gap-2">
    <RadioGroupItem id="a" value="a" /> A
  </div>
  <div className="flex items-center gap-2">
    <RadioGroupItem id="b" value="b" /> B
  </div>
</RadioGroup>
```

### Resizable (`resizable.tsx`)
- **Exports**: `ResizablePanelGroup`, `ResizablePanel`, `ResizableHandle`
- **Example**:
```tsx
import { ResizablePanelGroup, ResizablePanel, ResizableHandle } from '@/components/ui/resizable'

<ResizablePanelGroup direction="horizontal">
  <ResizablePanel defaultSize={50}>Left</ResizablePanel>
  <ResizableHandle />
  <ResizablePanel defaultSize={50}>Right</ResizablePanel>
</ResizablePanelGroup>
```

### Scroll Area (`scroll-area.tsx`)
- **Exports**: `ScrollArea`, `ScrollBar`
- **Example**:
```tsx
import { ScrollArea } from '@/components/ui/scroll-area'

<ScrollArea className="h-48 w-64">
  <div className="p-4 space-y-2">{Array.from({ length: 50 }).map((_, i) => <p key={i}>Item {i}</p>)}</div>
</ScrollArea>
```

### Select (`select.tsx`)
- **Exports**: `Select`, `SelectContent`, `SelectGroup`, `SelectItem`, `SelectLabel`, `SelectScrollDownButton`, `SelectScrollUpButton`, `SelectSeparator`, `SelectTrigger`, `SelectValue`
- **Example**:
```tsx
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from '@/components/ui/select'

<Select value="apple" onValueChange={console.log}>
  <SelectTrigger className="w-48">
    <SelectValue placeholder="Select a fruit" />
  </SelectTrigger>
  <SelectContent>
    <SelectItem value="apple">Apple</SelectItem>
    <SelectItem value="banana">Banana</SelectItem>
  </SelectContent>
</Select>
```

### Separator (`separator.tsx`)
- **Exports**: `Separator`
- **Example**:
```tsx
import { Separator } from '@/components/ui/separator'

<div>
  A
  <Separator className="my-2" />
  B
</div>
```

### Sheet (`sheet.tsx`)
- **Exports**: `Sheet`, `SheetTrigger`, `SheetClose`, `SheetContent`, `SheetHeader`, `SheetFooter`, `SheetTitle`, `SheetDescription`
- **Example**:
```tsx
import { Sheet, SheetTrigger, SheetContent, SheetHeader, SheetTitle } from '@/components/ui/sheet'

<Sheet>
  <SheetTrigger asChild>
    <button>Open sheet</button>
  </SheetTrigger>
  <SheetContent>
    <SheetHeader>
      <SheetTitle>Sheet</SheetTitle>
    </SheetHeader>
  </SheetContent>
</Sheet>
```

### Sidebar (`sidebar.tsx`)
- **Exports**: `Sidebar`, `SidebarContent`, `SidebarFooter`, `SidebarGroup`, `SidebarGroupAction`, `SidebarGroupContent`, `SidebarGroupLabel`, `SidebarHeader`, `SidebarInput`, `SidebarInset`, `SidebarMenu`, `SidebarMenuAction`, `SidebarMenuBadge`, `SidebarMenuButton`, `SidebarMenuItem`, `SidebarMenuSkeleton`, `SidebarMenuSub`, `SidebarMenuSubButton`, `SidebarMenuSubItem`, `SidebarProvider`, `SidebarRail`, `SidebarSeparator`, `SidebarTrigger`, `useSidebar`
- **Example** (minimal):
```tsx
import { Sidebar, SidebarProvider, SidebarTrigger, SidebarContent, SidebarMenu, SidebarMenuItem, SidebarMenuButton } from '@/components/ui/sidebar'

<SidebarProvider>
  <div className="flex">
    <Sidebar>
      <SidebarContent>
        <SidebarMenu>
          <SidebarMenuItem>
            <SidebarMenuButton>Dashboard</SidebarMenuButton>
          </SidebarMenuItem>
        </SidebarMenu>
      </SidebarContent>
    </Sidebar>
    <main className="flex-1">
      <SidebarTrigger />
      {/* page content */}
    </main>
  </div>
</SidebarProvider>
```

### Skeleton (`skeleton.tsx`)
- **Exports**: `Skeleton`
- **Example**:
```tsx
import { Skeleton } from '@/components/ui/skeleton'

<Skeleton className="h-8 w-64" />
```

### Slider (`slider.tsx`)
- **Exports**: `Slider`
- **Example**:
```tsx
import { Slider } from '@/components/ui/slider'

<Slider defaultValue={[33]} max={100} step={1} />
```

### Sonner (`sonner.tsx`)
- **Exports**: `Toaster`
- **Example**:
```tsx
import { Toaster } from '@/components/ui/sonner'

<Toaster />
```

### Switch (`switch.tsx`)
- **Exports**: `Switch`
- **Example**:
```tsx
import { Switch } from '@/components/ui/switch'

<label className="flex items-center gap-2">
  <Switch id="airplane-mode" /> Airplane Mode
</label>
```

### Table (`table.tsx`)
- **Exports**: `Table`, `TableHeader`, `TableBody`, `TableFooter`, `TableHead`, `TableRow`, `TableCell`, `TableCaption`
- **Example**:
```tsx
import { Table, TableHeader, TableBody, TableHead, TableRow, TableCell } from '@/components/ui/table'

<Table>
  <TableHeader>
    <TableRow>
      <TableHead>Name</TableHead>
      <TableHead>Role</TableHead>
    </TableRow>
  </TableHeader>
  <TableBody>
    <TableRow>
      <TableCell>Alex</TableCell>
      <TableCell>Engineer</TableCell>
    </TableRow>
  </TableBody>
</Table>
```

### Tabs (`tabs.tsx`)
- **Exports**: `Tabs`, `TabsList`, `TabsTrigger`, `TabsContent`
- **Example**:
```tsx
import { Tabs, TabsList, TabsTrigger, TabsContent } from '@/components/ui/tabs'

<Tabs defaultValue="account">
  <TabsList>
    <TabsTrigger value="account">Account</TabsTrigger>
    <TabsTrigger value="password">Password</TabsTrigger>
  </TabsList>
  <TabsContent value="account">Account tab</TabsContent>
  <TabsContent value="password">Password tab</TabsContent>
</Tabs>
```

### Textarea (`textarea.tsx`)
- **Exports**: `Textarea`
- **Example**:
```tsx
import { Textarea } from '@/components/ui/textarea'

<Textarea placeholder="Write something..." />
```

### Toggle Group (`toggle-group.tsx`)
- **Exports**: `ToggleGroup`, `ToggleGroupItem`
- **Example**:
```tsx
import { ToggleGroup, ToggleGroupItem } from '@/components/ui/toggle-group'

<ToggleGroup type="single" defaultValue="left">
  <ToggleGroupItem value="left">Left</ToggleGroupItem>
  <ToggleGroupItem value="center">Center</ToggleGroupItem>
  <ToggleGroupItem value="right">Right</ToggleGroupItem>
</ToggleGroup>
```

### Toggle (`toggle.tsx`)
- **Exports**: `Toggle`, `toggleVariants`
- **Example**:
```tsx
import { Toggle } from '@/components/ui/toggle'

<Toggle aria-label="Toggle bold">B</Toggle>
```

### Tooltip (`tooltip.tsx`)
- **Exports**: `Tooltip`, `TooltipTrigger`, `TooltipContent`, `TooltipProvider`
- **Example**:
```tsx
import { Tooltip, TooltipProvider, TooltipTrigger, TooltipContent } from '@/components/ui/tooltip'

<TooltipProvider>
  <Tooltip>
    <TooltipTrigger asChild>
      <button>Hover me</button>
    </TooltipTrigger>
    <TooltipContent>Helpful info</TooltipContent>
  </Tooltip>
</TooltipProvider>
```